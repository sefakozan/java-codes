package Ders13;

// ============================================================
// KAPSULLEME (Encapsulation) — Musteri
// private alanlar + kontrollu setter + is kurallari
// ============================================================
class Musteri {
    private static int sonMusteriId = 0;

    private int musteriId;
    private String adSoyad;
    private String email;
    private String telefon;

    public Musteri(String adSoyad, String email, String telefon) {
        this.musteriId = ++sonMusteriId;
        this.adSoyad = adSoyad;
        setEmail(email);      // kontrollu setter
        setTelefon(telefon);  // kontrollu setter
    }

    public int getMusteriId() {
        return musteriId;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("⚠ Gecersiz e-posta. 'Bilinmiyor' atandi.");
            this.email = "Bilinmiyor";
        }
    }

    public void setTelefon(String telefon) {
        // Basit dogrulama: sadece rakam ve + isareti kabul edelim
        if (telefon != null && telefon.matches("[0-9+ ]{8,20}")) {
            this.telefon = telefon;
        } else {
            System.out.println("⚠ Gecersiz telefon. 'Bilinmiyor' atandi.");
            this.telefon = "Bilinmiyor";
        }
    }

    public void bilgiGoster() {
        System.out.println("Musteri #" + musteriId + " — " + adSoyad
                + " | Email: " + email
                + " | Tel: " + telefon);
    }
}
