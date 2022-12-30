class UstGiyim extends Urun{
    protected String beden;
    
    public UstGiyim(String isim, int fiyat, String beden) {
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.beden = beden;
    }
    public UstGiyim(String isim, int fiyat, String beden, int adet){
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.setStok(adet);
        this.beden = beden;
    }
        
    }