# STACK & HEAP MEMORY

- Bellek MB seviyesinde
- Primitive türler stackte tutulur (Value Type)
- Non-primitive(Reference Type) türler hash codu (referansı) stackte tutulur, verisi heapte tutulur.
- null stackte tutulur
- null referans heapte hiçbir yer göstermeyen referanstır
- null 64 bitten oluşan 0'dır
- Non-primitive türler stackte tutulamayacak boyutta olduğu için heapte tutulur
- OS'e göre Stack ve Heap alanı değişiklik gösterir. Stack genelde mb, heap gb boyutundadır.

#### Primitive Tür

- **byte:** 8 bit, tam sayı (-128 ile 127 arasında)
- **short:** 16 bit, tam sayı (-32,768 ile 32,767 arasında)
- **int:** 32 bit, tam sayı (-2^31 ile 2^31-1 arasında)
- **long:** 64 bit, tam sayı (-2^63 ile 2^63-1 arasında)
- **float:** 32 bit, ondalıklı sayı (tek hassasiyetli)
- **double:** 64 bit, ondalıklı sayı (çift hassasiyetli)
- **char:** 16 bit, tek bir Unicode karakter
- **boolean:** true veya false değerlerini tutar (boyutu JVM'ye bağlı, genellikle 1 bit)  
  fiziksel makina veriyi 1 bit olarak okumaz 1 byte olarak okur

---

Data Types

         1. Primitive Types
            Bellekte doğrudan değerlerini tutar
            null değerini desteklemez, bu da bazı senaryolarda (örneğin, veri tabanlarında NULL değerini temsil etme) sorun yaratabilir.

         2. Non-Primitive Types (Hash, Reference)
            Nesnelere veya bellekteki bir adrese işaret eden veri tipleridir.
            Heapte tutulan verinin hash kodu (referansı) stackte tutulur.

            Non-Primitive Tiplerin Türleri
            1.1 Sınıflar (Classes)
            1.2 Arayüzler (Interfaces)
            1.3 Diziler (Arrays)
            1.4 Enum Tipler
            1.5 Record Tipler (Java 14 ve sonrası)
            1.6 Generic Tipler

         3. Wrapper Types
            Java'da wrapper(sarmak) sınıflar, primitive veri tiplerini nesne (object) haline getirmek için kullanılır.
        Wrapper sınıflar, Java'nın nesne yönelimli doğasıyla uyumluluk, ek işlevsellik, null desteği ve
        koleksiyonlarla çalışma gibi ihtiyaçları karşılamak için geliştirilmiştir.

        Genel (Generic) Tiplerle Uyumluluk:
            Java'da generic sınıflar (örneğin, List<T>) yalnızca nesne tipleriyle çalışır.
        Primitive tipler generic sınıflarda kullanılamaz, bu yüzden wrapper sınıflar devreye girer.

        int primitive0 = 10;
        Integer wrapper0 = primitive0; // Autoboxing: int otomatik olarak Integer nesnesine çevrilir

        Integer wrapper1 = 10;
        int primitive1 = wrapper1; // Unboxing: Integer nesnesi otomatik olarak int'e çevrilir

