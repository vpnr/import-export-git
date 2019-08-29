package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe representant l'entite {@link Syndicat} dans l'unite de persistence.
 * @author myPC
 *
 */

@Entity
@Table(name = "syndicat")
public class Syndicat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_syndicat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "libelle_syndicat", nullable = false, length = 45)
    @Size(min=1, max=50, message="Le libellé de l'entreprise ne doit pas être vide.")
    @Pattern(regexp="(^[A-Za-z0-9 \\é\\à\\â\\î\\ê\\è\\ô\\û\\ö\\ï\\ë\\ä_-]*$)", message="Les caractères spéciaux ne sont pas autorisés.")
    private String libelle;
    
    @Column(name = "numero_rue", nullable = true, length = 10)
    @Pattern(regexp="(^$|^[0-9]{1,4}$)", message="Numéro de rue invalide ex : 12")
    @Size(max=4)
    private String numeroRue;
    
    @Column(name = "libelle_rue", nullable = true, length = 150)
    @Pattern(regexp="(^$|^[A-Za-z \\é\\à\\â\\î\\ê\\è\\ô\\û\\ö\\ï\\ë\\ä_-]*$)", message="Les caractères spéciaux ne sont pas autorisés.")
    @Size(max=100)
    private String libelleRue;
    
    @Column(name = "cp_syndicat", nullable = true, length = 150)
    @Pattern(regexp="(^$|^[0-9]{5}|2[ab]$)", message="Code postale invalide ex : 92350")
    @Size(max=5)
    private String cp;
    
    @Column(name = "ville_syndicat", nullable = true, length = 150)
    @Pattern(regexp="(^$|^[A-Za-z \\é\\à\\â\\î\\ê\\è\\ô\\û\\ö\\ï\\ë\\ä_-]*$)", message="Les caractères spéciaux ne sont pas autorisés.")
    @Size(max=50)
    private String ville;
    
    @Column(name = "tel_syndicat", nullable = true, length = 15)
    @Pattern(regexp="(^$|^0[0-9]{9}$)", message="Téléphone invalide ex : 0836656565")
    @Size(max=10)
    private String tel;
    
    @Column(name = "fax_syndicat", nullable = true, length = 15)
    @Pattern(regexp="(^$|^0[0-9]{9}$)", message="Fax invalide ex : 0836656565")
    @Size(max=10)
    private String fax;
    
    @Column(name = "mail_syndicat", nullable = true, length = 100)
    @Pattern(regexp="(^$|[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$)", message="Email invalide ex : udgest@fo.fr")
    @Size(max=100)
    private String mail;
    
    @Column(name = "siteweb_syndicat", nullable = true, length = 150)
    @Pattern(regexp="(^$|\\www.[A-Za-z0-9._-]+\\.[A-Za-z]{2,6}$)", message="Site web invalide ex : www.spa-vitoha.fr")
    @Size(max=100)
    private String siteWeb;
    
    @ManyToOne
    @JoinColumn(name = "id_federation_syndicat", nullable = true)
    private Federation federation;
    
    @ManyToOne
    @JoinColumn(name = "id_ud_syndicat", nullable = true)
    private UnionDepartemental ud;
    
    @JsonIgnore
    @OneToMany(mappedBy = "syndicat")
    private List<Adherent> adherents;
    
    @JsonIgnore
    @OneToMany(mappedBy = "syndicat")
    private List<Event> events;
    
    /**
     * Default constructor.
     */
    public Syndicat() {
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }
    
    /**
     * @param paramTel the tel to set
     */
    public void setTel(String paramTel) {
        tel = paramTel;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param paramFax the fax to set
     */
    public void setFax(String paramFax) {
        fax = paramFax;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param paramMail the mail to set
     */
    public void setMail(String paramMail) {
        mail = paramMail;
    }

    /**
     * @return the siteWeb
     */
    public String getSiteWeb() {
        return siteWeb;
    }

    /**
     * @param paramSiteWeb the siteWeb to set
     */
    public void setSiteWeb(String paramSiteWeb) {
        siteWeb = paramSiteWeb;
    }

    /**
     * @return the adherents
     */
    public List<Adherent> getAdherents() {
        return adherents;
    }

    /**
     * @param paramAdherents the adherents to set
     */
    public void setAdherents(List<Adherent> paramAdherents) {
        adherents = paramAdherents;
    }

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String paramNumeroRue) {
		numeroRue = paramNumeroRue;
	}

	public String getLibelleRue() {
		return libelleRue;
	}

	public void setLibelleRue(String paramLibelleRue) {
		libelleRue = paramLibelleRue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public UnionDepartemental getUd() {
		return ud;
	}

	public void setUd(UnionDepartemental paramUd) {
		ud = paramUd;
	}

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation paramFederation) {
        federation = paramFederation;
    }

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Syndicat [id=" + id + ", libelle=" + libelle
				+ ", numeroRue=" + numeroRue + ", libelleRue=" + libelleRue + ", cp=" + cp + ", ville=" + ville
				+ ", tel=" + tel + ", fax=" + fax + ", mail=" + mail + ", siteWeb=" + siteWeb + "]";
	}
	
}
