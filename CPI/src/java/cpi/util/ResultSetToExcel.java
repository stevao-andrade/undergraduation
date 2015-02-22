/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import org.apache.commons.lang.exception.NestableException;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ResultSetToExcel {

    private Workbook workbook;
    private Sheet sheet;
    private Font boldFont;
    private DataFormat format;
    private ResultSet resultSet;
    private FormatType[] formatTypes;

    public ResultSetToExcel(ResultSet resultSet, FormatType[] formatTypes, String sheetName) {

        workbook = new HSSFWorkbook();

        this.resultSet = resultSet;

        sheet = workbook.createSheet(sheetName);

        boldFont = workbook.createFont();

        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);

        format = workbook.createDataFormat();

        this.formatTypes = formatTypes;

    }

    public ResultSetToExcel(ResultSet resultSet, String sheetName) {

        this(resultSet, null, sheetName);

    }

    private FormatType getFormatType(Class _class) {

        if (_class == Integer.class || _class == Long.class) {

            return FormatType.INTEGER;

        } else if (_class == Float.class || _class == Double.class) {

            return FormatType.FLOAT;

        } else if (_class == java.sql.Date.class) {

            return FormatType.DATE;

        } else if (_class == Timestamp.class) {

            return FormatType.TIMESTAMP;

        } else {

            return FormatType.TEXT;

        }

    }

    public void generate(OutputStream outputStream) throws Exception {

        try {

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            if (formatTypes != null && formatTypes.length != resultSetMetaData.getColumnCount()) {

                throw new IllegalStateException("Number of types is not identical to number of resultset columns. "
                        + "Number of types: " + formatTypes.length + ". Number of columns: " + resultSetMetaData.getColumnCount());

            }

            int currentRow = 0;

            Row row = sheet.createRow(currentRow);

            int numCols = resultSetMetaData.getColumnCount();

            boolean isAutoDecideFormatTypes;

            if (isAutoDecideFormatTypes = (formatTypes == null)) {

                formatTypes = new FormatType[numCols];

            }

            for (int i = 0; i < numCols; i++) {
                //Alteração getColumnName para getColumName//
                String title = resultSetMetaData.getColumnLabel(i + 1);
                writeCell(row, i, title, FormatType.TEXT, boldFont);
                if (isAutoDecideFormatTypes) {

                    Class _class = Class.forName(resultSetMetaData.getColumnClassName(i + 1));

                    formatTypes[i] = getFormatType(_class);

                }

            }

            currentRow++;

            // Write report rows

            while (resultSet.next()) {

                row = sheet.createRow(currentRow++);

                for (int i = 0; i < numCols; i++) {

                    Object value = resultSet.getObject(i + 1);

                    writeCell(row, i, value, formatTypes[i]);

                }

            }

            // Autosize columns

            for (int i = 0; i < numCols; i++) {
                sheet.autoSizeColumn(i);

            }

            workbook.write(outputStream);

        } finally {

            outputStream.close();

        }

    }

    public void generate(File file) throws Exception {

        generate(new FileOutputStream(file));

    }

    private void writeCell(Row row, int col, Object value, FormatType formatType) throws NestableException {

        writeCell(row, col, value, formatType, null, null);

    }

    private void writeCell(Row row, int col, Object value, FormatType formatType, Font font) throws NestableException {

        writeCell(row, col, value, formatType, null, font);

    }

    private void writeCell(Row row, int col, Object value, FormatType formatType,
            Short bgColor, Font font) throws NestableException {


        Cell cell = row.createCell(col);

        if (value == null) {

            return;

        }

        if (font != null) {

            CellStyle style = workbook.createCellStyle();

            style.setFont(font);

            cell.setCellStyle(style);

        }

        switch (formatType) {

            case TEXT:

                cell.setCellValue(value.toString());

                break;

            case INTEGER:

                cell.setCellValue(((Number) value).intValue());
                cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

                break;

            case FLOAT:

                cell.setCellValue(((Number) value).doubleValue());
                cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

                break;

            case DATE:

                cell.setCellValue(value.toString());
                //cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));


                break;

            case TIMESTAMP:

                cell.setCellValue(value.toString());
                //cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

                break;

            case MONEY:

                cell.setCellValue(((Number) value).intValue());
                cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("($#,##0.00);($#,##0.00)"));

                break;

            case PERCENTAGE:

                cell.setCellValue(((Number) value).doubleValue());

                cell.getCellStyle().setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        }

        if (bgColor != null) {
            cell.getCellStyle().setFillForegroundColor(bgColor);
            cell.getCellStyle().setFillPattern(CellStyle.SOLID_FOREGROUND);

        }

    }

    public enum FormatType {

        TEXT,
        INTEGER,
        FLOAT,
        DATE,
        TIMESTAMP,
        MONEY,
        PERCENTAGE
    }
}