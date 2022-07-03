package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name= "marketing")
public class Marketing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rede_social")
    @Size(max = 100)
    @NotNull
    private String redeSocial;

    @Column(name = "data_inicial")
    private Date dataInicial;

    @Column(name = "data_final")
    private Date dataFinal;

    @Size(max = 60)
    private String status;

    @OneToMany(mappedBy = "marketing")
    private List<Projeto> projetos;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getRedeSocial() {
        return redeSocial;
    }
    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "id=" + id +
                ", redeSocial='" + redeSocial + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", status='" + status + '\'' +
                '}';
    }
}
