import java.util.List;


public interface MatchStrategy {
    List<Match> realizarMatch(List<Doador> doadores, List<Receptor> receptores);
}