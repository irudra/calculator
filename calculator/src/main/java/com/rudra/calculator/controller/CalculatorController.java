package com.rudra.calculator.controller;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;
import com.rudra.calculator.operation.Type;
import com.rudra.calculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Main Controller class to define end points for the application.
 *
 * @author rudra
 */
@RestController
@Validated
public class CalculatorController {

    private final Calculator calculator;

    @Autowired
    CalculatorController(@Qualifier("cachedCalculator") final Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = {"/{operation}/{a}", "/{operation}/{a}/{b}",
            "/{operation}/{a}/{b}/{c}"}, method = RequestMethod.GET)
    public Result add(@PathVariable(value = "operation") final Type operation, @PathVariable(value = "a") final Integer a,
                      @PathVariable(value = "b") final Optional<Integer> b, @PathVariable(value = "c") final Optional<Integer> c) {
        final List<Integer> list = new ArrayList<>();
        list.add(a);
        b.ifPresent(list::add);
        c.ifPresent(list::add);
        return calculator.calculate(new Input(operation, list));
    }

}
