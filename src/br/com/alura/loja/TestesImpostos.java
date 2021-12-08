package br.com.alura.loja;

import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestesImpostos {

    public static void main(String[] args) {

        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImpostos calc = new CalculadoraDeImpostos();
        System.out.println(calc.calcular(orcamento, new ISS(new ICMS(null))));


//        System.out.println(carParkingRoof(Arrays.asList(6L,2L,12L,7L), 1));
//        System.out.println(reassignedPriorities(Arrays.asList(6,2,12,7)));

//        System.out.println(solution(3, new int[]{6,2,12,7}));
    }

//    public static int[] solution(int h, int[] q) {
//        // Your code here
//
//    }


    public static long carParkingRoof(List<Long> cars, int k) {
        if (cars.isEmpty()) {
            return 0L;
        }
        cars.sort(Comparator.comparing(Long::longValue));
        List<Long> roofCounts = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (i + k - 1 < cars.size()) {
                roofCounts.add(cars.get(i + k - 1) - cars.get(i) + 1);
            }
        }

        roofCounts.sort(Comparator.comparing(Long::longValue));

        return roofCounts.get(0);
    }

    public static List<Integer> reassignedPriorities(List<Integer> priorities) {
        List<Integer> prioritiesAux = new ArrayList<>(priorities);
        prioritiesAux = prioritiesAux.stream().distinct().collect(Collectors.toList());
        prioritiesAux.sort(Comparator.comparing(Integer::intValue));

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < prioritiesAux.size(); i++) {
            map.put(prioritiesAux.get(i), i + 1);
        }

        List<Integer> reassigned = new ArrayList<>();

        priorities.forEach(p -> reassigned.add(map.get(p)));

        return reassigned;
    }

}
