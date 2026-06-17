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

        
        
        ResultatCalcul resultat = null;

        try {
            double nb1 = Double.parseDouble(request.getParameter("nb1"));

            switch (request.getParameter("operation")) {
                case "addition":
                    double nb2Add = Double.parseDouble(request.getParameter("nb2"));
                    resultat = service.additionner(nb1, nb2Add);
                    break;
                case "soustraction":
                    double nb2Sub = Double.parseDouble(request.getParameter("nb2"));
                    resultat = service.soustraire(nb1, nb2Sub);
                    break;
                case "multiplication":
                    double nb2Mul = Double.parseDouble(request.getParameter("nb2"));
                    resultat = service.multiplier(nb1, nb2Mul);
                    break;
                case "division":
                    double nb2Div = Double.parseDouble(request.getParameter("nb2"));
                    resultat = service.diviser(nb1, nb2Div);
                    break;
                case "puissance":
                    double nb2Pow = Double.parseDouble(request.getParameter("nb2"));
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

  // pourque le resultat reste affichier sur la meme page index
        request.getSession().setAttribute("resultat", resultat);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}