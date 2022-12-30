class Ayakkabi extends Urun{
        private int numara;
        
    public Ayakkabi(String isim, int fiyat, int numara) {
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.numara = numara;
    }
    public Ayakkabi(String isim, int fiyat,int numara, int adet){
        this.setID(Urun.getSayac());
        this.setIsim(isim);
        this.setFiyat(fiyat);
        this.setStok(adet);
        this.numara = numara;
    }
    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }
}