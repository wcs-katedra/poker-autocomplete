package com.wcs.poker.gamestate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wcs.poker.gamestate.enums.PlayerState;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.util.Objects;

@Generated("org.jsonschema2pojo")
public class GameState {

    @SerializedName("small_blind")
    @Expose
    private Integer smallBlind;
    @SerializedName("current_buy_in")
    @Expose
    private Integer currentBuyIn;
    @Expose
    private Integer pot;
    @SerializedName("minimum_raise")
    @Expose
    private Integer minimumRaise = -9999;
    @Expose
    private Integer dealer;
    @Expose
    private Integer orbits;
    @SerializedName("in_action")
    @Expose
    private Integer inAction;
    @Expose
    private List<Player> players = new ArrayList<Player>();
    @SerializedName("community_cards")
    @Expose
    private List<Card> communityCards = new ArrayList<Card>();

    /**
     * A játékos állapota: - active as 'a': A játékos tud merakni tétet, még
     * megnyerheti a berakott pénzt - folded as 'f': A játékos bedobta,
     * következő körben ismét játszik - out as 'o': A játékos elvesztette minden
     * pénzét, ebben a játékban már nem játszik
     *
     * @param state which playerstate will be counted ?
     * @return the counted playerstate
     */
    public String getNumberOfPlayers(PlayerState state) {
        int countPlayers = 0;
        for (Player player : players) {
            switch (state) {
                case ACTIVE:
                    if ("active".equals(player.getStatus())) {
                        countPlayers++;
                    }
                    break;
                case FOLDED:
                    if ("folded".equals(player.getStatus())) {
                        countPlayers++;
                    }
                    break;
                case OUT:
                    if ("out".equals(player.getStatus())) {
                        countPlayers++;
                    }
                    break;
                default:
                    countPlayers++;
                    break;
            }
        }
        return String.valueOf(countPlayers);
    }

    /**
     * creates a list of the cards on the table and in the action player hand
     * append them then return it
     *
     * @return list of cards
     */
    public List<Card> cardsInTheGame() {
        List<Card> returnCards = new ArrayList<>();

        if (players != null && inAction != null && inAction > -1) {
            returnCards.addAll(players.get(inAction).getHoleCards());
        } else {
            returnCards.addAll(getAutocompletePlayer().getHoleCards());
        }
        if (communityCards != null) {
            returnCards.addAll(communityCards);
        }

        return returnCards;
    }

    private Player getAutocompletePlayer() {
        for (Player player : players) {
            if ("Just a few more commits needed".equals(player.getVersion())) {
                return player;
            }
        }

        return new Player();
    }

    public int getCurrentPlayerbBet() {
        if (inAction > -1) {
            return players.get(inAction).getBet();
        }
        return getAutocompletePlayer().getBet();
    }

    public int getCurrentPlayerStack() {
        if (inAction > -1) {
            return players.get(inAction).getStack();
        }
        return getAutocompletePlayer().getStack();

    }

    /**
     * how many cards left the dealer
     *
     * @return count them
     */
    public Integer getNumberOfCardInTheGame() {
        Integer cards = 0;

        // number of card owned play players
        for (Player player : this.getPlayers()) {
            if ("active".equals(player.getStatus())) {
                cards += 2;
            }
        }
        // number of cards on the table
        cards += this.getCommunityCards().size();

        return cards;
    }

    /**
     *
     * @return a valid call in the current circumstances
     */
    public int calculateCall() {

        return currentBuyIn - players.get(inAction).getBet();

    }

    /**
     *
     * @return minimum bet in the current circumstances
     */
    public int calculateMinimalBet() {
        return calculateCall() + minimumRaise;

    }

    public int getBigBlind() {
        return this.smallBlind * 2;
    }

    /**
     *
     * @return The smallBlind
     */
    public int getSmallBlind() {
        return smallBlind;
    }

    /**
     *
     * @param smallBlind The small_blind
     */
    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    /**
     *
     * @return The currentBuyIn
     */
    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    /**
     *
     * @param currentBuyIn The current_buy_in
     */
    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    /**
     *
     * @return The pot
     */
    public Integer getPot() {
        return pot;
    }

    /**
     *
     * @param pot The pot
     */
    public void setPot(Integer pot) {
        this.pot = pot;
    }

    /**
     *
     * @return The minimumRaise
     */
    public int getMinimumRaise() {
        return minimumRaise;
    }

    /**
     *
     * @param minimumRaise The minimum_raise
     */
    public void setMinimumRaise(Integer minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    /**
     *
     * @return The dealer
     */
    public Integer getDealer() {
        return dealer;
    }

    /**
     *
     * @param dealer The dealer
     */
    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    /**
     *
     * @return The orbits
     */
    public Integer getOrbits() {
        return orbits;
    }

    /**
     *
     * @param orbits The orbits
     */
    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    /**
     *
     * @return The inAction
     */
    public Integer getInAction() {
        return inAction;
    }

    /**
     *
     * @param inAction The in_action
     */
    public void setInAction(Integer inAction) {
        this.inAction = inAction;
    }

    /**
     *
     * @return The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @return The players
     */
    public List<Player> getPlayers(PlayerState state) {
        List<Player> activePlayers = new ArrayList<>();
        for (Player p : players) {
            if (state.name().toLowerCase().equals(p.getStatus())) {
                activePlayers.add(p);
            }
        }
        return players;
    }

    /**
     *
     * @param players The players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setPlayer(Player player) {
        this.players.clear();
        this.players.add(player);
    }

    public void setPlayer(int stack, int bet, Card card1, Card card2) {
        Player p = new Player();
        p.setBet(bet);
        p.setStack(stack);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        p.setHoleCards(cards);

        setPlayer(p);
    }

    /**
     *
     * @return The communityCards
     */
    public List<Card> getCommunityCards() {
        return communityCards;
    }

    /**
     *
     * @param communityCards The community_cards
     */
    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public void addNewPlayer(int stack, int bet, Card card1, Card card2) {
        Player player = new Player();
        player.setStack(stack);
        player.setBet(bet);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        player.setHoleCards(cards);

        players.add(player);
    }

    /**
     * :P
     *
     * @param rank
     * @param suit
     */
    public void addCard(String rank, String suit) {
        Card card = new Card();
        String json = "{rank : " + rank + ",suit: " + suit + "}";
        card = new JsonConverter<>(Card.class).fromJson(json);
        communityCards.add(card);
    }

    public void addCard(Card randomCard) {
        communityCards.add(randomCard);
    }

}
