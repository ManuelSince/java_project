package entities;

public class Chambre {
	private int id;
	private String numero;
	private int simpleBed;
	private int doubleBed;
	private int superficie;
	private int sdbP;
	private int tv;
	private int balcon;
	private int fridge;
	private int baignoire;
	private int insonorisation;
	private double prix;
	private int id_hotel;
	public Chambre() {}
	public Chambre(
			int id,
			String numero,
			int simpleBed,
			int doubleBed,
			int superficie,
			int sdbP,
			int tv,
			int balcon,
			int fridge,
			int baignoire,
			int insonorisation,
			double prix,
			int id_hotel
			) {
		setId(id);
		setNumero(numero);
		setSimpleBed(simpleBed);
		setDoubleBed(doubleBed);
		setSuperficie(superficie);
		setSdbP(sdbP);
		setTv(tv);
		setBalcon(balcon);
		setFridge(fridge);
		setBaignoire(baignoire);
		setInsonorisation(insonorisation);
		setPrix(prix);
		setIdHotel(id_hotel);
	}
	public Chambre(
			String numero,
			int simpleBed,
			int doubleBed,
			int superficie,
			int sdbP,
			int tv,
			int balcon,
			int fridge,
			int baignoire,
			int insonorisation,
			double prix,
			int id_hotel
			) {
		setNumero(numero);
		setSimpleBed(simpleBed);
		setDoubleBed(doubleBed);
		setSuperficie(superficie);
		setSdbP(sdbP);
		setTv(tv);
		setBalcon(balcon);
		setFridge(fridge);
		setBaignoire(baignoire);
		setInsonorisation(insonorisation);
		setPrix(prix);
		setIdHotel(id_hotel);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getSimpleBed() {
		return simpleBed;
	}
	public void setSimpleBed(int simpleBed) {
		this.simpleBed = simpleBed;
	}
	public int getDoubleBed() {
		return doubleBed;
	}
	public void setDoubleBed(int doubleBed) {
		this.doubleBed = doubleBed;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public int getSdbP() {
		return sdbP;
	}
	public void setSdbP(int sdbP) {
		this.sdbP = sdbP;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getBalcon() {
		return balcon;
	}
	public void setBalcon(int balcon) {
		this.balcon = balcon;
	}
	public int getFridge() {
		return fridge;
	}
	public void setFridge(int fridge) {
		this.fridge = fridge;
	}
	public int getBaignoire() {
		return baignoire;
	}
	public void setBaignoire(int baignoire) {
		this.baignoire = baignoire;
	}
	public int getInsonorisation() {
		return insonorisation;
	}
	public void setInsonorisation(int insonorisation) {
		this.insonorisation = insonorisation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getIdHotel() {
		return id_hotel;
	}
	public void setIdHotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	@Override
	public String toString() {
		return "Chambre [id=" + id + ", numero=" + numero + ", simpleBed=" + simpleBed + ", doubleBed=" + doubleBed
				+ ", superficie=" + superficie + ", sdbP=" + sdbP + ", tv=" + tv + ", balcon=" + balcon + ", fridge="
				+ fridge + ", baignoire=" + baignoire + ", insonorisation=" + insonorisation + ", prix=" + prix
				+ ", id_hotel=" + id_hotel + "]";
	}

}
