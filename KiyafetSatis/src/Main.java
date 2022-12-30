
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/****************************************** MERLİN BUTİK ******************************************************/

/*
*  (+) Kalıtım (en az 2) Giyim -> AltGiyim, UstGiyim ; Kullanıcı -> Admin, Musteri
*  (+) Abstract / Interface (en az 1) Urun
*  (+) Overloading (en az 3) UrunArama(), UrunDeğiştirme(), UrunAramaGiyim()
*  (+) Method (en az 20) main -> 1, admin -> 5, musteri -> 6, urun -> 8+1(toString())
*  (+) Exception (en az 2) UrunArama() -> Urun Bulunamadı ; FiyatAralıgıArama() -> Urun Bulunamadı
*  (+) Inner class (en az 1) Urun = Giyim + AltGiyim + UstGiyim + Ayakkabı + Aksesuar
*  
*/

public class Main { // 1 method
    public static void main(String[] args){
        ArrayList<Urun> urunListesi= new ArrayList<Urun>();
        Kullanici user = new Kullanici();
        
        UrunListesiniDoldur(urunListesi);
        
        Scanner scanner = new Scanner(System.in);
        
        do{
            System.out.print("Kullanıcı adı giriniz : ");
            user.setKullaniciAdi(scanner.nextLine());
            System.out.print("Şifreyi giriniz : ");
            user.setSifre(scanner.nextLine());
        
            if( user.getKullaniciAdi().equals("ceylin") && user.getSifre().equals("sifre")){
                user.setYetki("admin");
                break;
            }
            else if(user.getKullaniciAdi().equals("meryem") && user.getSifre().equals("sifre")){
                user.setYetki("musteri");
                break;
            }
            else if(!user.getKullaniciAdi().equals("username") && user.getSifre().equals("sifre")){
                System.out.println("Kullanıcı adı yanlış");
            }
            else if(user.getKullaniciAdi().equals("username") && !user.getSifre().equals("sifre")){
                System.out.println("Sifre yanlış");
            }
            else{
                System.out.println("Kullanıcı adı ve şifre yanlış");
            }
        }while(true);
        user.setIsim(user.getKullaniciAdi());
        int islem = 0, ID;
        if(user.getYetki().equals("admin")){
            Kullanici.Admin admin = new Kullanici().new Admin(user.getIsim());
            do{
                System.out.println("\n\nYapmak istediğiniz işlemi seçiniz :"
                        + "\n1 - Ürünü Ekle"
                        + "\n2 - Ürünü Sil"
                        + "\n3 - Ürünün Stoğunu Güncelle"
                        + "\n4 - Ürünün İsmini Güncelle"
                        + "\n5 - Ürünün Fiyatını Güncelle"
                        + "\n6 - Ürünleri Listele"
                        + "\n7 - Stoktaki Ürünleri Listele"
                        + "\n8 - Çıkış");
                islem = scanner.nextInt();
                switch (islem){
                    case 1:
                        urunListesi.add(admin.UrunEkle());
                        break;
                    case 2:
                        System.out.println("Silinecek ürünün ID'sini giriniz : ");
                        ID = scanner.nextInt();
                        admin.UrunSil(ID, urunListesi);
                        break;
                    case 3:
                        System.out.println("Stoğu güncellenecek ürünün ID'sini giriniz : ");
                        ID = scanner.nextInt();
                        System.out.println("Ürün adetini giriniz : ");
                        int adet = scanner.nextInt();
                        admin.StokGuncelleme(ID, urunListesi, adet);
                        break;
                    case 4:
                        System.out.println("İsmi güncellenecek ürünün ID'sinin giriniz : ");
                        ID = scanner.nextInt();
                        scanner.nextLine();// int'den sonra satır alırken hata verir bu nedenle bu satır var
                        System.out.println("Ürünün ismini giriniz : ");
                        String isim = scanner.nextLine();
                        admin.UrunDegistir(ID, urunListesi, isim);
                        break;
                    case 5:
                        System.out.println("Fiyatı güncellenecek ürünün ID'sinin giriniz : ");
                        ID = scanner.nextInt();
                        System.out.println("Ürünün fiyatını giriniz : ");
                        int fiyat = scanner.nextInt();
                        admin.UrunDegistir(ID, urunListesi, fiyat);
                        break;
                    case 6:
                        Urun.urunleriListele(urunListesi);
                        break;
                    case 7:
                        Urun.stoktakileriGoster(urunListesi);
                        break;
                    case 8:
                        System.out.println("Çıkış Yapılıyor...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Geçersiz kod girişi! Tekrar deneyin...");
                }
            }while(true);
        }
        
        else if(user.getYetki().equals("musteri")){
            Kullanici.Musteri musteri = new Kullanici().new Musteri(user.getIsim());
            do{
                try {
                    System.out.println("\n\nYapmak istediğiniz işlemi seçiniz :"
                            + "\n1 - Ürünleri Listele"
                            + "\n2 - Sepete Ürün Ekle"
                            + "\n3 - Sepetten Ürün Çıkart"
                            + "\n4 - Sepeti Tamamla"
                            + "\n5 - Sepeti Görüntüle"
                            + "\n6 - Sepeti Boşalt"
                            + "\n7 - Fiyat Aralığında Ürün Ara"
                            + "\n8 - İsim İle Ürün Ara"
                            + "\n9 - Beden İle Üst Giyim Ara"
                            + "\n10 - Beden İle Alt Giyim Ara"
                            + "\n11 - Numara İle Ayakkabı Ara"
                            + "\n12 - Stoktaki Ürünleri Listele"
                            + "\n13 - Çıkış Yap");
                    islem = scanner.nextInt();
                    switch (islem){
                        case 1:
                            Urun.urunleriListele(urunListesi);
                            break;
                        case 2:
                            System.out.println("Sepete eklenecek ürünün ID'sini giriniz");
                            ID = scanner.nextInt();
                            musteri.SepeteEkle(Urun.UrunArama(ID, urunListesi));
                            musteri.SepetiGoruntule();
                            break;
                        case 3:
                            System.out.println("Sepetten çıkarılacak ürünün ID'sini giriniz");
                            ID = scanner.nextInt();
                            musteri.SepettenCikart(Urun.UrunArama(ID, urunListesi));
                            musteri.SepetiGoruntule();
                            break;
                        case 4:
                            musteri.SepetiTamamla();
                            break;
                        case 5:
                            musteri.SepetiGoruntule();
                            break;
                        case 6:
                            System.out.println("Sepet boşaltılıyor...");
                            musteri.SepetiBosalt();
                            break;
                        case 7:
                            System.out.println("Aramak istediğiniz minimum tutarı giriniz");
                            int min = scanner.nextInt();
                            System.out.println("Aramak istediğiniz maksimum tutarı giriniz");
                            int max = scanner.nextInt();
                            for(Urun urun : Urun.FiyatAralıgıArama(min, max, urunListesi)){
                                System.out.println(urun);
                            }
                            break;
                        case 8:
                            System.out.println("Aramak istediğiniz isimdeki ürünü giriniz");
                            scanner.nextLine();
                            String isim = scanner.nextLine();
                            for(Urun urun : Urun.UrunArama(isim, urunListesi)){
                                System.out.println(urun);
                            }
                            break;
                        case 9:
                            System.out.println("Aramak istediğiniz bedeni giriniz");
                            scanner.nextLine();
                            String bedenUst = scanner.nextLine();
                            Urun.urunleriListele(Urun.UrunAramaGiyim(bedenUst, urunListesi));
                            break;
                        case 10:
                            System.out.println("Aramak istediğiniz bedeni giriniz");
                            scanner.nextLine();
                            int bedenAlt = scanner.nextInt();
                            Urun.urunleriListele(Urun.UrunAramaGiyim(bedenAlt, urunListesi));
                            break;
                        case 11:
                            System.out.println("Aramak istediğiniz numarayı giriniz");
                            scanner.nextLine();
                            int numara = scanner.nextInt();
                            Urun.urunleriListele(Urun.UrunAramaGiyim(numara, urunListesi));
                            break;
                        case 12:
                            Urun.stoktakileriGoster(urunListesi);
                            break;
                        case 13:
                            System.out.println("Çıkış yapılıyor...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Geçersiz kod girişi! Tekrar deneyin...");
                            
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }while(true);
        }
        
    }
    
    public static ArrayList<Urun> UrunListesiniDoldur(ArrayList<Urun> liste){
        liste.add(new AltGiyim("Pantolon", 200, 44, 10));
        liste.add(new UstGiyim("Gömlek", 400, "xl"));
        liste.add(new Ayakkabi("Spor", 600, 40, 0));
        liste.add(new Aksesuar("Çanta", 1200, 5));
        return liste;
    }
}
