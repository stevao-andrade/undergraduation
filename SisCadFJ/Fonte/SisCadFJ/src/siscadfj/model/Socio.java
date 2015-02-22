/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.model;

/**
 *
 * @author fj_informatica
 */
public class Socio {

    private String nome;
    private String cpf;
    private String rg;
    private String matricula;
    private String sexo;
    private String dia;     // data de nascimento.
    private String mes; //data de nascimento.
    private String ano;   //data de nascimento.
    private String endereco;
    private String numEndereco;
    private String Bairro;
    private String cidade;
    private String estado;
    private String fone;
    private String cel;
    private String email;
    private String bloco;
    private String funcao;
    private int id;
    private int idAlterado;
    private String data;

    public Socio(String nome, String cpf, String rg, String matricula, String sexo, String dia, String mes, String ano, String endereco, String numEndereco, String Bairro, String cidade, String estado, String fone, String cel, String email, String bloco, String funcao, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.fone = fone;
        this.cel = cel;
        this.email = email;
        this.bloco = bloco;
        this.funcao = funcao;
        this.data = data;
    }



    public Socio(String nome, String cpf, String rg, String matricula, String sexo, String dia, String mes, String ano, String endereco, String numEndereco, String Bairro, String cidade, String estado, String fone, String cel, String email, String bloco, String funcao, int id, int idAlterado) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.fone = fone;
        this.cel = cel;
        this.email = email;
        this.bloco = bloco;
        this.funcao = funcao;
        this.id = id;
        this.idAlterado = idAlterado;
    }

    

    public Socio(String nome, String cpf, String rg, String matricula, String sexo, String dia, String mes, String ano, String endereco, String numEndereco, String Bairro, String cidade, String estado, String fone, String cel, String email, String bloco, String funcao, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.fone = fone;
        this.cel = cel;
        this.email = email;
        this.bloco = bloco;
        this.funcao = funcao;
        this.id = id;
    }


    

    public Socio(String nome, String cpf, String rg, String matricula, String sexo, String dia, String mes, String ano, String endereco, String numEndereco, String Bairro, String cidade, String estado, String fone, String cel, String email, String bloco, String funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.fone = fone;
        this.cel = cel;
        this.email = email;
        this.bloco = bloco;
        this.funcao = funcao;
    }

    public Socio() {
    }

    public Socio(String nome, String matricula, String bloco, String funcao, int id) {
        this.nome = nome;
        this.matricula = matricula;
        this.bloco = bloco;
        this.funcao = funcao;
        this.id = id;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdAlterado() {
        return idAlterado;
    }

    public void setIdAlterado(int idAlterado) {
        this.idAlterado = idAlterado;
    }
    

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String  getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    


}
