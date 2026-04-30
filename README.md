# Explicatie Mod Functionare Aplicatie Client-Server

### 1. TCP (cu conexiune)
* *Cum se realizeaza conexiunea:* TCP stabileste o conexiune initiala folosind procesul de "3-Way Handshake" inainte de a transmite date[cite: 1]. Serverul asteapta conectarea pe portul definit (ex: 5000), iar clientul o initiaza, stabilind un canal de comunicare stabil[cite: 1].
* *Cum sunt trimise mesajele:* Mesajele sunt trimise ca un flux continuu, organizate in segmente[cite: 1]. Clientul si serverul isi trimit datele pe rand (ping-pong), folosind acelasi socket pe toata durata conversatiei[cite: 1].

### 2. UDP (fara conexiune)
* *Cum se realizeaza conexiunea:* UDP nu stabileste o conexiune in prealabil[cite: 1]. Etapa de handshake initial este complet absenta[cite: 1].
* *Cum sunt trimise mesajele:* Mesajele sunt trimise independent, sub forma de datagrame, direct catre adresa IP si portul destinatarului[cite: 1]. Serverul foloseste functii specifice (ex: recvfrom) pentru a primi datele si pentru a extrage adresa IP si portul expeditorului din primul pachet, astfel incat sa stie unde sa trimita raspunsul inapoi[cite: 1].

### 3. Diferente observate in Wireshark
* *Handshake Initial:* La TCP este prezent (apar pachetele de tip SYN, SYN-ACK, ACK la inceput), in timp ce la UDP lipseste cu desavarsire[cite: 1].
* *Confirmarea primirii:* Protocolul TCP confirma primirea datelor prin pachete de tip ACK[cite: 1]. La protocolul UDP, primirea nu se confirma[cite: 1].
* *Denumire PDU:* In Wireshark se observa ca traficul TCP este format din "Segmente", in timp ce traficul UDP este format din "Datagrame"[cite: 1].

---

### Capturi Wireshark
1. *Captura TCP:* (Aici vom insera imaginea cu filtrul tcp.port == 5000 care arata handshake-ul)[cite: 1]
2. *Captura UDP:* (Aici vom insera imaginea cu filtrul udp.port == 5001 care arata pachetele transmise direct)[cite: 1]


<img width="1600" height="960" alt="server_tcp" src="https://github.com/user-attachments/assets/387cff98-3105-4379-a3db-315ea0053f90" />
<img width="1215" height="825" alt="client_tcp" src="https://github.com/user-attachments/assets/c3c04e3d-947f-4724-9729-7f34c4bd55e3" />
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/UwOds2hL)
