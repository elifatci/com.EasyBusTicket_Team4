# com.EasyBusTicket
### Team4
### 
***

1. Test Files Package isimlendirmesi==> US01_Reporter seklinde olmali
2. Package altinda olusturulacak class isimlendirmesi==>US01_TC01 seklinde olmali

3. Locate alinan element nerenin elementi oldugu aciklama satiri ile aciklanmali
* Aciklama Satiri Find By notasyonunun ustune yazilmali.
  || orn:  Homepage>> LoginLink>> Email Text Box ||

<br/>

### Git

### SAKIN MAİN'DE PUSH YAPMAAAA!!
***

1. Herkes kendi adina birer branch olusturur.
    * `git branch <isim>`

2. sag alt panelde branc ismimizin yazili oldugu kisimdan
    * main' e tikliyoruz
    * update'e tikliyoruz
    * sonra merge 'main' into 'brancismi' yazan kısma tikliyoruz
    * bu şekilde pull işlemini gerçekleştirmiş oluyoruz

3. Yaptigi degisiklikleri kucuk commitlerle kendi branchinda saklar. Burada tavsiye edilen sadece sizin yaptiginiz degisikliklerin eklenmesidir.
    * Yapilan degisikliklerin tamamini olusturdugunuz branchte yapmalisiniz!!
    * `git status` yazmalisiniz. Terminalde kirmizi cikan dosya yolunu git add komutunun yanina yapistirin!!
    * `git add <statustan alinan isim>` islemini kendi branchinizde yapmalisiniz!!
    * `git commit -m  "İsim/tarih/Yapilan Degisiklikler icin bir mesaj yazilir."`
      Örn >>> git commit -m "<Kendi isminiz>/02.07/loginClassEklendi"
    * `git push`
    * terminalde gelen linkten ustteki linke tiklanir ve github hesabi sayfasi acilir
    * Push ettigimiz kendi kodumuz icin **request** olusturulur ve İS BİTER.

4. Merge islemi Team Lead tarafindan gerceklestirilir

5. Projede işlem yapmadan once izlenecek adimlar:
    * `git branch` ile hangi branchte oldugumuzu kontrol ediyoruz.
    * `git checkout main` ile main branchine geciyoruz.
    * `git pull` ile mainde yapilmis olan tum degisikligi kendi ide'mize çekiyoruz.
    * `git checkout branchIsmi` ile vakit kaybetmeden KOSARAK HIZLICA kendi branchimize geciyoruz.
    * `git merge main` komutuyla main branch ile kendi branchimizi birlestiriyoruz ve artik projede calismak icin haziriz.



### Isimlendirmelerde dikkat edilecekler
***
| Element Türü   | Variable name |
|----------------|---------------|
| Button         | buttonsignIn  |    
| Logo           | logoX         |
| icon           | iconX         |
| Sadece text    | textX         |
| Drop down      | dropDownX     |
| Radio Button   | radioButtonX  |
| Check box      | checkBoxX     |
| Tablo Sütünu   | columnX       |
| Tablo Satiri   | rowX          |
| Kisi Resimleri | imageProfileX |
| ürün resimleri | imageProductX |
| Linkler        | linkX         |
