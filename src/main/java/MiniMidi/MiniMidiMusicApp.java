package MiniMidi;


import javax.sound.midi.*;

public class MiniMidiMusicApp {

    public static void main(String[] args) {
        MiniMidiMusicApp mini = new MiniMidiMusicApp();
        SimpleGui gui = new SimpleGui();
        gui.go();

        if(args.length < 2) {
            System.out.println("Do not forget the arguments for the instrument and notes.");
        }else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }


    private void play(int instrument, int note) {
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open(); //получили и открыли синтезатор
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument); //нота начинает играть

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff); //нота заканчивает играть
            player.setSequence(seq);
            player.start();

        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
