import socket

SERVER_IP = '100.83.108.35'
PORT = 5000


def main():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        print(f"Trying to connect to {SERVER_IP}:{PORT}...")
        client_socket.connect((SERVER_IP, PORT))
        print("Connected to the Java server!\n")

        while True:
            my_message = input("You (Python): ")
            client_socket.sendall((my_message + '\n').encode('utf-8'))

            if my_message.strip().lower() == 'exit':
                print("You left the chat. Closing connection...")
                break

            server_message = client_socket.recv(1024).decode('utf-8')

            if not server_message or server_message.strip().lower() == 'exit':
                print("The server (Java) closed the chat.")
                break

            print(f"Colleague (Java): {server_message.strip()}")

    except Exception as e:
        print(f"Connection error: {e}")
    finally:
        client_socket.close()


main()