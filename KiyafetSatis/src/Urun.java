import java.util.ArrayList;

public abstract class Urun {
    private int fiyat;
    private String isim;
    private static int sayac = 0;
    private int ID;
    private int stok = 1;

    public static int getSayac() {
        return sayac++;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public static ArrayList<Urun> UrunArama(String isim, ArrayList<Urun> liste) throws Exception{
        ArrayList<Urun> aramaSonucu = new ArrayList<Urun>();
        for(Urun urun : liste){
            if(isim.equalsIgnoreCase(urun.isim)){
                aramaSonucu.add(urun);
            }
        }
        if(aramaSonucu.size() == 0){
            throw new Exception("Bu İsimde Urun Bulunamadı");
        }
        return aramaSonucu;
    }
    public static Urun UrunArama(int ID, ArrayList<Urun> liste) throws Exception{
        for(Urun urun : liste){
            if(urun.ID == ID){
                return urun;
            }
        }
        throw new Exception("Bu ID'de Urun Bulunamadı");
    }
    public static ArrayList<Urun> UrunAramaGiyim(int beden, ArrayList<Urun> liste) throws Exception{
        ArrayList<Urun> aramaSonucu = new ArrayList<Urun>();
        for(Urun urun : liste){
            if(urun instanceof AltGiyim){
                if(((AltGiyim)urun).getBeden() == beden){
                    aramaSonucu.add(urun);
                }
            }
        }
        if(aramaSonucu.size() == 0){
            throw new Exception("Bu bedende ürün bulunamadı");
        }
        return aramaSonucu;
    }
    public static ArrayList<Urun> UrunAramaGiyim(String beden, ArrayList<Urun> liste) throws Exception{
        ArrayList<Urun> aramaSonucu = new ArrayList<Urun>();
        for(Urun urun : liste){
            if(urun instanceof UstGiyim){
                if(((UstGiyim) urun).beden.equalsIgnoreCase(beden)){
                    aramaSonucu.add(urun);
                }
            }
        }
        if(aramaSonucu.size() == 0){
            throw new Exception("Bu bedende ürün bulunamadı");
        }
        return aramaSonucu;
    }
    public static ArrayList<Urun> UrunAramaAyakkabi(int numara, ArrayList<Urun> liste) throws Exception{
        ArrayList<Urun> aramaSonucu = new ArrayList<Urun>();
        for(Urun urun : liste){
            if(urun instanceof Ayakkabi){
                if(((Ayakkabi) urun).getNumara() == numara){
                    aramaSonucu.add(urun);
                }
            }
        }
        if(aramaSonucu.size() == 0){
            throw new Exception("Bu bedende ürün bulunamadı");
        }
        return aramaSonucu;
    }
    public static ArrayList<Urun> FiyatAralıgıArama(int min, int max, ArrayList<Urun> liste) throws Exception{
        ArrayList<Urun> aramaSonucu = new ArrayList<Urun>();
        for(Urun urun : liste){
            if((urun.fiyat >= min) && (urun.fiyat <= max)){
                aramaSonucu.add(urun);
            }
        }
        if(aramaSonucu.size() == 0){
            throw new Exception("Bu Fiyat Aralığında Urun Bulunamadı");
        }
        return aramaSonucu;
    }
    public static void urunleriListele(ArrayList<Urun> liste){
        for(Urun urun : liste){
            System.out.println(urun);
        }
    }
    public static void stoktakileriGoster(ArrayList<Urun> liste){
        for(Urun urun : liste){
            if(urun.stok != 0) {
                System.out.println(urun);
            }
        }
    }

    @Override
    public String toString() {
        return "\n\nÜrün İsmi : " + isim + "\nÜrünün ID'si : " + ID + "\nÜrünün Fiyatı : " + fiyat + "\nÜrünün Stoğu : " + stok;
    }
    
}
