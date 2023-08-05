import json
import time

import classeviva
from classeviva import *
import classeviva.eccezioni
import socket

HOST = ''
PORT = 50007

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen(1)
conn, addr = s.accept()
print("Conntected by", addr)

while True:
    length_of_message = int.from_bytes(conn.recv(2), byteorder='big')
    username = conn.recv(length_of_message).decode("UTF-8")
    length_of_message = int.from_bytes(conn.recv(2), byteorder='big')
    password = conn.recv(length_of_message).decode("UTF-8")
    if not username or password:
        break


utente = classeviva.Utente(username, password)
utente()
print(utente.stato)

def getAssenze():
    assenze = asyncio.run(utente.assenze())
    s = ""

    for x in range (0, len(assenze)):
        s += (str)(assenze[x]["evtCode"])
        s += ";"
        s += (str)(assenze[x]["evtDate"])
        s += ";"
        s += (str)(assenze[x]["isJustified"])
        s += ";"

    print(s)
    return s

tette = "tette"
conn.sendall(tette.encode("UTF-8"))
txt = getAssenze()
conn.sendall(txt.encode("UTF-8"))

# while True:
#     length_of_message = int.from_bytes(conn.recv(2), byteorder='big')
#     username = conn.recv(length_of_message).decode("UTF-8")
#     if not username: break
#     if username == "chiudi": s.close()

s.close()
