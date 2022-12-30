import java.util.ArrayList;
import java.util.Scanner;


public class Kullanici {
    private String isim;
    private String soyisim;
    private String kullaniciAdi;
    private String sifre;
    private String yetki;
    
    public Kullanici() {
        System.out.println("Merlin Butiğe Hoşgeldiniz!");
    }

    public String getYetki() {
        return yetki;
    }
    public void setYetki(String yetki) {
        this.yetki = yetki;
    }
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getSoyisim() {
        return soyisim;
    }
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    public class Admin{ //5 method

        public Admin(String ad) {
            isim = ad;
            System.out.println("Hoşgeldin " + isim);
        }
        
        public Urun UrunEkle(){
            Scanner scanner = new Scanner(System.in);
            int secim, fiyat, adet=0;
            String isim;
            do{
                System.out.println("Oluşturulacak ürünün türünü seçiniz : \n1 - Alt Giyim\n2 - Üst Giyim\n3 - Ayakkabı\n4 - Aksesuar\n5 - Ürün Eklemeden Çıkış");
                secim = scanner.nextInt();
                scanner.nextLine();
                switch(secim){
                    case 1:
                        System.out.print("Alt giyimin ismini giriniz : ");
                        isim = scanner.nextLine();
                        System.out.print("Alt giyimin bedenini giriniz : ");
                        int bedenAlt = scanner.nextInt();
                        System.out.print("Alt giyimin fiyatını giriniz : ");
                        fiyat = scanner.nextInt();
                        System.out.print("Eklenecek alt giyimin miktarını giriniz : ");
                        adet = scanner.nextInt();
                        if(adet == 1){
                            AltGiyim urun = new AltGiyim(isim, fiyat, bedenAlt);
                            return urun;
                        }
                        else{
                            AltGiyim urun = new AltGiyim(isim, fiyat, bedenAlt, adet);
                            return urun;
                        }
                        
                    case 2:
                        System.out.print("Üst giyimin ismini giriniz : ");
                        isim = scanner.nextLine();
                        System.out.print("Üst giyimin bedenini giriniz : ");
                        String bedenUst = scanner.nextLine();
                        System.out.print("Üst giyimin fiyatını giriniz : ");
                        fiyat = scanner.nextInt();
                        System.out.print("Eklenecek üst giyimin miktarını giriniz : ");
                        adet = scanner.nextInt();
                        if(adet == 1){
                            UstGiyim urun = new UstGiyim(isim, fiyat, bedenUst);
                            return urun;
                        }
                        else{
                            UstGiyim urun = new UstGiyim(isim, fiyat, bedenUst, adet);
                            return urun;
                        }
                    case 3:
                        System.out.print("Ayakkabının ismini giriniz : ");
                        isim = scanner.nextLine();
                        System.out.print("Ayakkabının numarasını giriniz : ");
                        int numara = scanner.nextInt();
                        System.out.print("Ayakkabının fiyatını giriniz : ");
                        fiyat = scanner.nextInt();
                        System.out.print("Eklenecek ayakkabının miktarını giriniz : ");
                        adet = scanner.nextInt();
                        if(adet == 1){
                            Ayakkabi urun = new Ayakkabi(isim, fiyat, numara);
                            return urun;
                        }
                        else{
                            Ayakkabi urun = new Ayakkabi(isim, fiyat, numara, adet);
                            return urun;
                        }
                    case 4:
                        System.out.print("Aksesuarın ismini giriniz : ");
                        isim = scanner.nextLine();
                        System.out.print("Aksesuarın fiyatını giriniz : ");
                        fiyat = scanner.nextInt();
                        System.out.print("Eklenecek aksesuarın miktarını giriniz : ");
                        adet = scanner.nextInt();
                        if(adet == 1){
                            Aksesuar urun = new Aksesuar(isim, fiyat);
                            return urun;
                        }
                        else{
                            Aksesuar urun = new Aksesuar(isim, fiyat, adet);
                            return urun;
                        }
                    case 5:
                        System.out.println("İşlem iptal edilmiştir.");
                        break;
                    default:
                        System.out.println("Geçersiz işlem!");
                        break;
                }
            }while(secim != 5);
            return null;
        }
        public void UrunSil(int ID, ArrayList<Urun> liste){
            try {
                liste.remove(Urun.UrunArama(ID, liste));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        public void UrunDegistir(int ID, ArrayList<Urun> liste, String isim){
            try {
                Urun.UrunArama(ID, liste).setIsim(isim);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        public void UrunDegistir(int ID, ArrayList<Urun> liste, int fiyat){
            try {
                Urun.UrunArama(ID, liste).setFiyat(fiyat);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        public void StokGuncelleme(int ID, ArrayList<Urun> liste, int adet){
            try {
                Urun.UrunArama(ID, liste).setStok(adet);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public class Musteri{ //5 method
        private ArrayList<Urun> sepet = new ArrayList<Urun>();
        private String adres;

        public Musteri(String ad) {
            isim = ad;
            System.out.println("Hoşgeldiniz "+isim);
        }

        public String getAdres() {
            return adres;
        }

        public void setAdres(String adres) {
            this.adres = adres;
        }

        public void SepeteEkle(Urun urun){
            sepet.add(urun);
        }
        public void SepettenCikart(Urun urun){
            sepet.remove(urun);
        }
        public void SepetiTamamla(){
            int toplam=0;
            SepetiGoruntule();

            if(sepet.size() > 0){
                for(Urun urun : sepet){
                toplam += urun.getFiyat();
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Toplam Tutar : " + toplam);
                System.out.println("Sepetinizi Onaylıyor Musunuz? (E/H)");

                while(true){
                    String onay = scanner.next();
                    switch(onay.toUpperCase()){
                        case "E":
                            System.out.println("Sepetiniz Onaylanmıştır\n Siparişiniz oluşturuluyor...");
                            for(Urun urun : sepet){
                                urun.setStok(urun.getStok() - 1);
                            }
                            FaturaOlustur();
                            System.out.println("Bizden alışveriş yaptığınız için teşekkürler <3");
                            SepetiBosalt();
                            return;
                        case "H":
                            System.out.println("Sepetinizi Onaylamadınız!..");
                            return;
                        default:
                            System.out.println("Geçersiz Giriş");
                            break;
                    }
                }
            }

        }
        public void SepetiGoruntule(){
            if(sepet.size() == 0){
                System.out.println("Sepet boş");
                return;
            }
            System.out.println("Sepetteki Urunler : ");
            for(Urun urun : sepet){
                System.out.println(urun);
            }
        }
        public void SepetiBosalt(){
            sepet.clear();
            SepetiGoruntule();
        }
        public void FaturaOlustur(){
            System.out.println("Faturanız Oluşturuluyor...");
            System.out.println("İsim: "+getIsim()+"\nSoyisim: "+getSoyisim()+"\nAdres: "+adres);
        }
    }
}
