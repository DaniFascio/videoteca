package it.sincrono.videoteca;

import it.sincrono.videoteca.Movie;
import it.sincrono.videoteca.MovieRepository;
import org.apache.catalina.filters.ExpiresFilter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// classe controller

@Controller
public class MovieController {

    //oggetto di tipo MovieRepository

    @Autowired
    private MovieRepository mr;



    // metodo di gestione per l'azione view che permette la visualizzazione di un singolo film tramite id del film
    // se il film non viene trovato porta ad una pagina di errore

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView viewget(@RequestParam String id){

        ModelAndView mw;
        Optional<Movie> mo = mr.findById(new ObjectId(id));
        if(mo.isPresent()){
            mw = new ModelAndView("view");
            mw.addObject("movie",mo.get());
        }
        else
            mw = new ModelAndView("error404");

        return mw;

    }


    // metodi che permettono l'inserimento di un film tramite la pagina insert html.
    // I due metodi sono uno get e uno post.

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insertget(){

        ModelAndView mw = new ModelAndView("insert");
        mw.addObject("movie");

        return mw;

    }



    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertpost(@RequestParam String actors, @RequestParam String description,
                               @RequestParam int duration, @RequestParam String genre, @RequestParam String languages,
                               @RequestParam double price, @RequestParam int publishYear, @RequestParam String subtitles,
                               @RequestParam String title){

        ModelAndView mw = new ModelAndView("insert");
        List<Actor> lista = Arrays.stream(actors.split(";")).map(Actor::new).collect(Collectors.toList());
        mr.insert(new Movie(lista,description,duration,genre,languages.split(";"),price,publishYear,subtitles.split(";"),title));



        return new ModelAndView("redirect:/home");
    }


    // metodi che permettono la modifica di un film tramite id utilizzando la pagina update html.
    // I due metodi sono uno get e uno post.


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateget(@RequestParam String id){


        ModelAndView mw;
        Optional<Movie> mo = mr.findById(new ObjectId(id));
        if(mo.isPresent()){
            mw = new ModelAndView("update");
            mw.addObject("movie",mo.get());
        }
        else
            mw = new ModelAndView("error404");

        return mw;

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updatepost(@RequestParam String id, @RequestParam String actors, @RequestParam String description,
                                   @RequestParam int duration, @RequestParam String genre, @RequestParam String languages,
                                   @RequestParam double price, @RequestParam int publishYear, @RequestParam String subtitles,
                                   @RequestParam String title){

            ModelAndView mw;

            mw = new ModelAndView("update");

            List<Actor> lista = Arrays.stream(actors.split(";")).map(Actor::new).collect(Collectors.toList());
            mr.save(new Movie(new ObjectId(id),lista,description,duration,genre,languages.split(";"),price,publishYear,subtitles.split(";"),title));


        return new ModelAndView("redirect:/home");
    }



    // metodo che permette l'eliminazione di un film tramite id del film

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam String id) {


        ModelAndView mw;
        Optional<Movie> mo = mr.findById(new ObjectId(id));
        if(mo.isPresent()) {
            mw = new ModelAndView("home");
            mw.addObject("movies", mr.findAll());
            mr.delete(mo.get());
        }
        else
            new ModelAndView("error404");

        return new ModelAndView("confirmdel");
    }

    //metodo che permette di tornare alla pagina home

    @RequestMapping("/home")
    public ModelAndView home(){

        ModelAndView mw = new ModelAndView("home");
        mw.addObject("movies",mr.findAll());

        return mw;
    }



}
