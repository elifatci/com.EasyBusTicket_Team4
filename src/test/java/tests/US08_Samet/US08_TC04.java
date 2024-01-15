package tests.US08_Samet;

import org.testng.annotations.Test;

public class US08_TC04 {
    @Test
            public void emailTetst(){

    // 1. "https://qa.easybusticket.com/contact" adresine git, bu siteye ait iletişim sayfasıdır.
    // 2. 'Contact' sayfasında 'Have any Questions?' adlı iletişim formunun görünürlüğünü doğrula.
    // 3. İletişim formundaki 'Name' alanına herhangi bir veri girmeyin.
    // 4. Diğer alanlara uygun verileri girin (Email, Konu ve Mesaj).
    // 5. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 6. Düğmeye tıklandığında 'Name' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 7. 'Name' alanına uygun olmayan veriler girin (Bu alanda sadece boşluk karakterleriyle test edilmiştir. Sayılar ve özel karakterleri kabul edebildiği için bu tür bir girişle test yapılmamıştır).
    // 8. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 9. Düğmeye tıklandıktan sonra, sayfanın sağ üst köşesinde "The name field is required" (İsim alanı zorunludur) hatası görüntülendiğini doğrula.
    // 10. Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
    // 11. Sayfaya geri dönüldükten sonra 'Name' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.
    // 12. İletişim formundaki 'Email' alanına herhangi bir veri girmeyin.
    // 13. Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
    // 14. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 15. Düğmeye tıklandığında 'Email' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 16. 'Email' alanına uygun olmayan verileri girin.
    // 17. Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
    // 18. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 19. Düğmeye tıklandığında 'Email' alanının altında 'Lütfen e-posta adresine bir "@" işareti ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 20. 'Email' alanına uygun olmayan verileri girin.
    // 21. Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
    // 22. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 23. Düğmeye tıklandığında 'Email' alanının altında 'Lütfen "@" işaretinden sonra gelen kısmı ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 24. 'Email' alanına uygun olmayan verileri girin.
    // 25. Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
    // 26. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 27. Düğmeye tıklandığında 'Email' alanının altında 'Lütfen "@" işaretinden sonra gelen kısma "." şeklinde alan adı ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 28. 'Subject' alanına herhangi bir veri girmeyin.
    // 29. Diğer alanlara uygun verileri girin (Name, Email ve Mesaj).
    // 30. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 31. Düğmeye tıklandığında 'Subject' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 32. 'Subject' alanına uygun olmayan verileri girin.
    // 33. Diğer alanlara uygun verileri girin (Name, Email ve Mesaj).
    // 34. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 35. Düğmeye tıklandığında, sayfanın sağ üst köşesinde "The subject field is required" (Konu alanı zorunludur) hatası görüntülendiğini doğrula.
    // 36. Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
    // 37. Sayfaya geri dönüldükten sonra 'Subject' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.
    // 38. İletişim formundaki 'Message' alanına herhangi bir veri girmeyin.
    // 39. Diğer alanlara uygun verileri girin (Name, Email ve Konu).
    // 40. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 41. Düğmeye tıklandığında 'Message' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
    // 42. 'Message' alanına uygun olmayan verileri girin.
    // 43. İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
    // 44. Düğmeye tıklandığında, sayfanın sağ üst köşesinde "The message field is required" (Mesaj alanı zorunludur) hatası görüntülendiğini doğrula.
    // 45. Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
    // 46. Sayfaya geri dönüldükten sonra 'Message' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.

    }
}
