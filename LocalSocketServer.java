package module_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalSocketServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8089);
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            out.println("Привет!");

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("req = " + response);
                if (response.trim().equalsIgnoreCase("q")) {
                    break;
                }

                System.out.println("res = " + response);
                out.println(String.format("Получил сообщение: %s", response));
            }

            out.println("Пока!");

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
