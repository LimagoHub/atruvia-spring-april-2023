package de.atruvia.webapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

//@Component
@Scope("singleton")
public class Demo {


    private final Translator translator;


    private final String meldung;
    private final Set<String> mail;


    @Autowired
    public Demo(/*@Qualifier("upper")*/ final Translator translator, @Value("${Demo.message}") final String message, Set<String> mail) {
        this.translator = translator;
        this.meldung = message;
        this.mail = mail;
        System.out.println(meldung);
        System.out.println(translator.translate("Constructor von Demo"));
    }

//    public Translator getTranslator() {
//        return translator;
//    }
//
//    @Autowired
//    public void setTranslator(final Translator translator) {
//        this.translator = translator;
//    }

//    public Demo() {
//        System.out.println("Constructor von Demo");
//    }

    @PostConstruct
    private void init() {
        System.out.println(meldung);
        System.out.println(translator.translate("Postconstruct"));
        System.out.println(mail);
    }
}
