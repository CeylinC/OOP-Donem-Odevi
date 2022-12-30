class Aksesuar extends Urun{
    
    public Aksesuar(String isim, int fiyat) {
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
    }
    public Aksesuar(String isim, int fiyat, int adet){
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.setStok(adet);
    }
        
    }