package bdbt_bada_projekt.SpringApplication.models;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Towary")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID_Samochodu;
    private String Marka;
    private String Model;
    private Date Data_produkcji;
    private String Nr_VIN;
    private float Pojemnosc_silnika;

    public Cars(int ID_Samochodu, String marka, String model, Date data_produkcji, String nr_VIN, float pojemnosc_silnika) {
        ID_Samochodu = ID_Samochodu;
        Marka = marka;
        Model = model;
        Data_produkcji = data_produkcji;
        Nr_VIN = nr_VIN;
        Pojemnosc_silnika = pojemnosc_silnika;
    }

    public Cars() {

    }

    public int getID_Samochodu() {
        return ID_Samochodu;
    }

    public void setID_Samochodu(int ID_Samochodu) {
        this.ID_Samochodu = ID_Samochodu;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Date getData_produkcji() {
        return Data_produkcji;
    }

    public void setData_produkcji(Date data_produkcji) {
        Data_produkcji = data_produkcji;
    }

    public String getNr_VIN() {
        return Nr_VIN;
    }

    public void setNr_VIN(String nr_VIN) {
        Nr_VIN = nr_VIN;
    }

    public float getPojemnosc_silnika() {
        return Pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(float pojemnosc_silnika) {
        Pojemnosc_silnika = pojemnosc_silnika;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "ID_Samochodu=" + ID_Samochodu +
                ", Marka='" + Marka  +
                ", Model='" + Model  +
                ", Data_produkcji=" + Data_produkcji +
                ", Nr_VIN='" + Nr_VIN  +
                ", Pojemnosc_silnika=" + Pojemnosc_silnika +
                '}';
    }
}
