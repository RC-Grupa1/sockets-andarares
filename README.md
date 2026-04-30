# Aplicație Chat Client-Server folosind TCP și UDP

Acest proiect implementează o aplicație simplă de tip chat client-server folosind socket-uri.  
Serverul este implementat în **Java**, iar clientul este implementat în **Python**.  

Scopul aplicației este de a demonstra diferențele dintre protocoalele **TCP (Transmission Control Protocol)** și **UDP (User Datagram Protocol)**, precum și analiza traficului de rețea folosind Wireshark.

---

# 1. TCP (Protocol orientat pe conexiune)

## Cum se realizează conexiunea

Protocolul TCP stabilește o conexiune înainte de transmiterea datelor prin procesul numit **Three-Way Handshake**.

Acest proces implică trei pași:

- SYN – clientul trimite o cerere de conexiune către server
- SYN-ACK – serverul confirmă cererea și răspunde
- ACK – clientul confirmă conexiunea

După finalizarea acestui proces, conexiunea devine stabilă și datele pot fi transmise între client și server.

Serverul ascultă conexiuni pe un port specific (de exemplu **portul 5000**), iar clientul inițiază conexiunea către acel port.

## Cum sunt trimise mesajele

Mesajele sunt transmise sub forma unui **flux continuu de date**, organizate în segmente.

În aplicația noastră, comunicarea are loc în stil **Ping-Pong**:

1. Clientul trimite un mesaj.
2. Serverul îl primește și îl afișează.
3. Serverul trimite un răspuns.
4. Clientul primește răspunsul.

Această comunicare continuă până când unul dintre utilizatori trimite mesajul **"exit"**, moment în care conexiunea se închide grațios.

---

# 2. UDP (Protocol fără conexiune)

## Cum se realizează conexiunea

Protocolul UDP **nu stabilește o conexiune înainte de transmiterea datelor**.  

Nu există un proces de handshake, ceea ce face comunicarea mai rapidă, dar mai puțin sigură.

## Cum sunt trimise mesajele

Mesajele sunt trimise sub forma unor **datagrame independente**, direct către adresa IP și portul destinatarului.

Serverul folosește funcția `recvfrom()` pentru a:

- primi datagramele
- identifica adresa IP a clientului
- identifica portul clientului

După ce primește primul pachet, serverul știe unde să trimită răspunsul.

---

# 3. Diferențe observate în Wireshark

## Handshake inițial

- **TCP:** Handshake-ul este vizibil în captură prin pachetele  
  `SYN → SYN-ACK → ACK`
- **UDP:** Nu există handshake.

## Confirmarea primirii datelor

- **TCP:** Confirmă primirea datelor folosind pachete **ACK**.
- **UDP:** Nu există mecanism de confirmare.

## Denumirea PDU

În Wireshark, tipurile de pachete sunt diferite:

- **TCP:** Segmente
- **UDP:** Datagrame

---

# Capturi Wireshark

## Captură TCP

Filtru utilizat în Wireshark:


<img width="1600" height="960" alt="server_tcp" src="https://github.com/user-attachments/assets/387cff98-3105-4379-a3db-315ea0053f90" />
<img width="1215" height="825" alt="client_tcp" src="https://github.com/user-attachments/assets/c3c04e3d-947f-4724-9729-7f34c4bd55e3" />
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/UwOds2hL)
