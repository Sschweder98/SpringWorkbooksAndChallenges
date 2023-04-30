package com.ltp.globalsuperstore.controllers;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.ltp.globalsuperstore.Constants.NOT_FOUND;

@Controller
public class InventoryController {
    private List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Integer itemID = getItemIndex(id);
        Item item;
        if (itemID >= 0) {
            item = items.get(itemID);
        }
        else {
            item = new Item();
        }
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("item", item);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes){
        Integer itemID = getItemIndex(item.getId());
        String status = Constants.SUCCESS_STATUS;

        if (itemID == NOT_FOUND) {
            items.add(item);
        }
        else if (within5Days(item.getDate(), items.get(itemID).getDate())) {
            items.set(itemID, item);
        }
        else{
            status = Constants.FAILED_STATUS;
        }

        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    public Integer getItemIndex(String id){
        for (int i=0;i< items.size(); i++){
            if (items.get(i).getId().equals(id)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
