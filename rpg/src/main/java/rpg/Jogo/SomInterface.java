package rpg.Jogo;

import javax.sound.sampled.*;

public class SomInterface {
    private static SourceDataLine sdl;

    static {
        try {
            AudioFormat af = new AudioFormat(8000f, 8, 1, true, false);
            sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBeep() {
        if (sdl == null) return;

        // Frequência reduzida para um som menos agudo
        float frequency = 300f; // foi reduzida de 1400f para 300f
        int duration = 35; // duração ligeiramente aumentada
        byte[] buf = new byte[1];

        for (int i = 0; i < duration * 8; i++) {
            double angle = i / (8000f / frequency) * 2.0 * Math.PI;

            // Adicionando um envelope para suavizar o som
            double envelope;
            if (i < duration * 2) {
                envelope = i / (double)(duration * 2); // Ataque gradual
            } else {
                envelope = 1.0 - (i / (double)(duration * 8)); // Decay gradual
            }

            buf[0] = (byte)(Math.sin(angle) * 40 * envelope); // volume reduzido
            sdl.write(buf, 0, 1);
        }
    }

    public static void fecharBeep() {
        if (sdl != null) {
            sdl.drain();
            sdl.stop();
            sdl.close();
        }
    }
}