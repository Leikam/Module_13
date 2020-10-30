package module_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import org.w3c.dom.ls.LSOutput;

public class LocaleSocketClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8089);
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
            String s = in.readLine();
            System.out.println("Ответ = " + s);

            System.out.println("Введите сообщение:");
            String message = clientIn.readLine();
            if (message.equalsIgnoreCase("q")) {
                break;
            }

            System.out.println("Отправлено = " + message);
            out.println(message);
        }

        out.close();
        in.close();
        clientIn.close();
        socket.close();

    }
}
