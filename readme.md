# Szablon projektu na konkurs orginizowany przez PSI.

# Potrzebujesz:
### Java 11 np:
```
https://adoptopenjdk.net/releases.html?variant=openjdk11&jvmVariant=hotspot
```
### Maven:
```
https://maven.apache.org/download.cgi
```

##
Jak uruchomić:
Włącz CMD w lokacji z projektem i wpisz 
```
mvn clean install && mvn javafx:run
```

Do włączenia aplikacji nie potrzebujesz żadnego IDE, osobiście polecam jedyne słuszne tj. IntelliJ Idea.
Po wprowadzeniu swoich zmian aplikacji za każdym razem możesz przekompilować i właczyć instrukcją:
```
mvn clean install && mvn javafx:run
```

##
TREŚĆ ZADANIA KONKURSOWEGO:
Wymagania:
Użytkownik ma możliwość zamówienia pizzy z menu.
Język - JAVA
Interfejs użytkownika - konsola interaktywna lub JavaFX - piękne gui rozstrzygać będzie jedynie w przypadku remisu. Oceniamy kod logiki biznesowej.

###
Ciasto cienkie:
MENU:
MARGERITTA        13.50
Sos pomidorowy, mozzarella
MARINARA        14.40
Sos pomidorowy, mozzarella, czosnek
NAPOLETANA        16.50
Sos pomidorowy, mozzarella, czarne oliwki
HAWAJSKA        14.40
Sos pomidorowy, mozzarella, ananas
FUNGHI            14.10
Sos pomidorowy, mozzarella, pieczarki
QUATRO STAGIONI    18.20
Sos pomidorowy, mozzarella, szynka, karczochy, papryka
CAPRICCIOSA        16.80
Sos pomidorowy, mozzarella, szynka, pieczarki
DINAMITE        15.10
Sos pomidorowy, mozzarella, salami pikantne

###
Ciasto grube:
MENU:
MARGERITTA        15.50
Sos pomidorowy, mozzarella
MARINARA        16.40
Sos pomidorowy, mozzarella, czosnek
NAPOLETANA        18.50
Sos pomidorowy, mozzarella, czarne oliwki
HAWAJSKA        16.40
Sos pomidorowy, mozzarella, ananas
FUNGHI            16.10
Sos pomidorowy, mozzarella, pieczarki
QUATRO STAGIONI    20.20
Sos pomidorowy, mozzarella, szynka, karczochy, papryka
CAPRICCIOSA        18.80
Sos pomidorowy, mozzarella, szynka, pieczarki
DINAMITE        17.10
Sos pomidorowy, mozzarella, salami pikantne

###
Opcjonalnie użytkownik może wybrać jakieś dodatki
Dodatkowe składniki:
papryka             0,80
czosnek                0,90
pieczarki             1,10
ananas                1,40
mozzerella             1,50
salami                1,60
karczochy            1,70
kukurydza            1,90
sos pomidorowy        2,00
bekon                2,10
szynka                 2,20
sos czosnkowy        2,50
oliwa z oliwek        3,00
czarne oliwki        3,20

###
Cena pizzy obliczana jest wg wzoru:
ciasto + cena użytych składników
Koszt ciasta cienkiego   10PLN
Koszt ciasta grubego     12PLN

###
Zadanie dodatkowe:
 - pizza z dowozem +4 PLN / +5PLN /+6PLN (użytkownik podaje dzielnice, do której ma być dostarczona pizza [nie rozpoznajemy dzielnicy na podstawie adresu]. Grunwald 4PLN, Stare miasto/Wilda/Jeżyce 5PLN, Nowe miasto 6PLN )
 - zniżka studencka 20% - na podstawie deklaracji użytkownika - tak jestem studentem