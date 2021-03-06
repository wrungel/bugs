package frol;


import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import java.util.List;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.listOf;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

public class VerfuegbareTarifkalender {

    private KalenderInstantiator Kalender;
    private KalenderversionInstantiator Kalenderversion;
    private KalenderdatensatzInstantiator Kalenderdatensatz;


    private Kalender kalenderSommerWinter() {
        return make(a(Kalender,
                with(KalenderInstantiator.kalenderversionen, listOf(
                        a(Kalenderversion,
                                with(KalenderversionInstantiator.gueltigVon, (Object) null),
                                with(KalenderversionInstantiator.kalenderdatensaetze, listOf(
                                        a(Kalenderdatensatz,
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null)
                                        ),
                                        a(Kalenderdatensatz,
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null)
                                        ),
                                        a(Kalenderdatensatz,
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null)
                                        ),
                                        a(Kalenderdatensatz,
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null),
                                                with(KalenderdatensatzInstantiator.mittwoch, (Object) null)
                                        )
                                ))
                        )
                ))
        ));
    }


    public static class KalenderdatensatzInstantiator implements Instantiator<Kalenderdatensatz> {
        public static final Property<Kalenderdatensatz, Object> mittwoch = Property.newProperty();
        public Kalenderdatensatz instantiate(PropertyLookup<Kalenderdatensatz> lookup) {
            return null;
        }
    }

    public static class KalenderInstantiator implements Instantiator<Kalender>{
        public static final Property<Kalender, List<Kalenderversion>> kalenderversionen = Property.newProperty();

        public Kalender instantiate(PropertyLookup<Kalender> lookup) {
            return null;
        }
    }

    public static class KalenderversionInstantiator implements Instantiator<Kalenderversion> {
        public static final Property<Kalenderversion, Object> gueltigVon = Property.newProperty();
        public static final Property<Kalenderversion, List<Kalenderdatensatz>> kalenderdatensaetze = Property.newProperty();

        public Kalenderversion instantiate(PropertyLookup<Kalenderversion> lookup) {
            return null;
        }
    }

    class Kalenderversion {}
    class Kalender {}
    class Kalenderdatensatz {}
}
