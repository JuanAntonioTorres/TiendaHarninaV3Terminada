package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "codigo_postal", schema = "tienda_harnina20189vistas")
public class CodigoPostalEntity {

    private String codigoPostal;

    @Basic
    @Column(name = "CodigoPostal")
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoPostalEntity that = (CodigoPostalEntity) o;
        return Objects.equals(codigoPostal, that.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPostal);
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
