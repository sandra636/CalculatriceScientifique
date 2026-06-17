package co.kozao.calculatricescientifique.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.kozao.calculatricescientifique.service.CalculatriceService;
import co.kozao.calculatricescientifique.model.ResultatCalcul;

@WebServlet("/calculer")
public class CalculatriceServlet extends HttpServlet {

    private CalculatriceService service;

    @Override
    public void init() throws ServletException {
        service = new CalculatriceService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        String nb1Str = request.getParameter("nb1");
        String nb2Str = request.getParameter("nb2");
        ResultatCalcul resultat = null;

        try {
            double nb1 = Double.parseDouble(nb1Str);

            switch (operation) {
                case "addition":
                    double nb2Add = Double.parseDouble(nb2Str);
                    resultat = service.additionner(nb1, nb2Add);
                    break;
                case "soustraction":
                    double nb2Sub = Double.parseDouble(nb2Str);
                    resultat = service.soustraire(nb1, nb2Sub);
                    break;
                case "multiplication":
                    double nb2Mul = Double.parseDouble(nb2Str);
                    resultat = service.multiplier(nb1, nb2Mul);
                    break;
                case "division":
                    double nb2Div = Double.parseDouble(nb2Str);
                    resultat = service.diviser(nb1, nb2Div);
                    break;
                case "puissance":
                    double nb2Pow = Double.parseDouble(nb2Str);
                    resultat = service.puissance(nb1, nb2Pow);
                    break;
                case "racine":
                    resultat = service.racine(nb1);
                    break;
                case "factorielle":
                    resultat = service.factorielle((int) nb1);
                    break;
                default:
                    resultat = new ResultatCalcul("Opération inconnue");
            }

        } catch (NumberFormatException e) {
            resultat = new ResultatCalcul("Erreur : veuillez saisir des nombres valides");
        }

        request.setAttribute("resultat", resultat);
        request.setAttribute("nb1", nb1Str);
        request.setAttribute("nb2", nb2Str);
        request.setAttribute("operation", operation);
        request.getRequestDispatcher("/resultat.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}