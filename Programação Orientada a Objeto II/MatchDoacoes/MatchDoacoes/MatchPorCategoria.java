import java.util.ArrayList;
import java.util.List;


public class MatchPorCategoria implements MatchStrategy {
    @Override
    public List<Match> realizarMatch(List<Doador> doadores, List<Receptor> receptores) {
        List<Match> matches = new ArrayList<>();
        
        for (Doador doador : doadores) {
            for (Item itemDoado : doador.getItensParaDoar()) {
                for (Receptor receptor : receptores) {
                    for (Item itemNecessario : receptor.getItensNecessarios()) {
                        if (itemDoado.getCategoria().equalsIgnoreCase(itemNecessario.getCategoria())) {
                            matches.add(new Match(doador, receptor, itemDoado));
                        }
                    }
                }
            }
        }
        
        return matches;
    }
}