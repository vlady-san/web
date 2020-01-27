package njp.NaumenJavaProject.controllers;

import njp.NaumenJavaProject.forms.BookingTable;
import njp.NaumenJavaProject.forms.SelectDateForm;
import njp.NaumenJavaProject.models.Tables;
import njp.NaumenJavaProject.servises.TablesServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BookingController {
    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String bookingTable(Model model) {
        return("booking");
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView bookingTable (@ModelAttribute BookingTable bookingTable) {
        TablesServices t=new TablesServices();
        Tables table=new Tables();
        table.setName(bookingTable.getName());
        table.setPhone(bookingTable.getPhone());
        table.setDate(bookingTable.getDate());
        table.setTime(bookingTable.getTime());
        table.setNumT(Integer.parseInt(bookingTable.getTableNum()));
        t.saveUser(table);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/booking");
        mav.addObject("bookingTable", bookingTable);
        mav.addObject("end", true);
        return mav;
    }

    @RequestMapping(value = "/selectDate", method = RequestMethod.POST)
    public ModelAndView selectDate (@ModelAttribute SelectDateForm selectDateForm) throws ParseException {
        List<Integer> list=Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13);
        List<Integer> res=new ArrayList<Integer>();
        TablesServices t=new TablesServices();
        System.out.println(selectDateForm.getDate());
        List<Integer> tables=t.findAllBooked(selectDateForm.getDate());
        System.out.println(tables.size());
        for(Integer el:list) {
            if (!tables.contains(el)) res.add(el);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/booking");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(selectDateForm.getDate());
        Date date2 = new Date();
        if(date.getTime()<date2.getTime())
            return mav;
        mav.addObject("list", res);
        mav.addObject("date", selectDateForm.getDate());
        return mav;
    }
}
