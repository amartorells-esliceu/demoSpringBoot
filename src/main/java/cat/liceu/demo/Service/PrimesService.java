package cat.liceu.demo.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimesService {
    public List<Integer> getPrimes(int max) {
        List<Integer> primers = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (esPrimer(i)) {
                primers.add(i);
            }
        }
        return primers;
    }

    private boolean esPrimer(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
