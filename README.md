Acesta este un sistem de gestionare a comenzilor care permite utilizatorilor să adauge, să șteargă și să caute produse, să adauge și să șteargă recenzii, să caute recenzii pentru un anumit produs și să adauge și să șteargă utilizatori. Sistemul permite, de asemenea, utilizatorilor să sorteze comenzile după ID și să adauge, să șteargă și să caute comenzile.

Clasele sistemului
Clasele enum
OrderStatus - Enumerația stărilor comenzii (ex. "În așteptare", "În procesare", "Finalizată").

ProductCategory - Enumerația categoriilor de produse (ex. "Carte", "Îmbrăcăminte", "Electronică").

Clasa abstractă
Product - Clasa abstractă care definește caracteristicile generale ale unui produs(nume,pret). Această clasă este moștenită de Book, Clothing și Electronics.
Clasele concrete
Book - Clasa care definește un produs de tip carte.

Clothing - Clasa care definește un produs de tip îmbrăcăminte.

Electronics - Clasa care definește un produs de tip electronic.

Address - Clasa care definește o adresă, cu proprietăți specifice (ex. nume stradă,oraș,tara, cod poștal).

Notification - Clasa care definește o notificare, cu proprietăți specifice ( mesaj, data).

Order - Clasa care definește o comandă, cu proprietăți specifice (ex. ID,data,produse,Adresa de livrare,status).

Review - Clasa care definește o recenzie(text,rating).

ShoppingCart - Clasa care definește un coș de cumpărături (ex. produse).

User - Clasa care definește un utilizator, cu proprietăți specifice (ex. nume, email, parolă,Adresa preferata,Produse favorite,Cosul de cumparaturi,Istoricul Comenzilor,Notificari).

Clasa de serviciu
OrderService - Clasa care expune operațiile sistemului. Această clasă conține metode pentru adăugarea, ștergerea și căutarea produselor, adăugarea și ștergerea recenziilor, căutarea recenziilor pentru un anumit produs, adăugarea și ștergerea utilizatorilor, sortarea comenzilor după ID, adăugarea, ștergerea și căutarea comenzilor.
Clasa Main:Clasa care expune anumite situatii ipotetice de utilizare a operatiilor de sistem.
