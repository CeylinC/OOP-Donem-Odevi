class AltGiyim extends Urun{
    private int beden;
    
    public AltGiyim(String isim, int fiyat, int beden) {
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.beden = beden;
    }
    
    public AltGiyim(String isim, int fiyat, int beden, int adet){
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.setStok(adet);
        this.beden = beden;
    }
    
    public int getBeden() {
        return beden;
    }

    public void setBeden(int beden) {
        this.beden = beden;
    }
}