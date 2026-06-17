<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculatrice Scientifique</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <div class="logo"><span>🧮</span></div>
        <h1>Calculatrice Scientifique</h1>
        <p class="subtitle"></p>

        <form action="calculer" method="post">

            <div class="form-group">
                <label for="nb1">Nombre 1</label>
                <input type="number" id="nb1" name="nb1"
                       value="${nb1}" step="any" placeholder="Ex: 25" required/>
            </div>

            <div class="form-group">
                <label for="operation">Opération</label>
                <select id="operation" name="operation" onchange="toggleNb2()">
                    <option value="addition">➕ Addition</option>
                    <option value="soustraction">➖ Soustraction</option>
                    <option value="multiplication">✖️ Multiplication</option>
                    <option value="division">➗ Division</option>
                    <option value="puissance">⬆️ Puissance (aⁿ)</option>
                    <option value="racine">√ Racine carrée</option>
                    <option value="factorielle">❕ Factorielle (n!)</option>
                </select>
            </div>

            <div class="form-group">
                <label for="nb2">
                    Nombre 2
                    <span class="nb2-badge" id="nb2Badge">Requis</span>
                </label>
                <input type="number" id="nb2" name="nb2"
                       value="${nb2}" step="any" placeholder="Ex: 5"/>
            </div>

            <button type="submit" class="btn-calculer">Calculer</button>

        </form>

        

        <hr class="divider"/>
        <jsp:include page="resultat.jsp"/>
    </div>


    <script>
        const sansNb2 = ["racine", "factorielle"];

        function toggleNb2() {
            const operation = document.getElementById("operation").value;
            const nb2Input  = document.getElementById("nb2");
            const nb2Badge  = document.getElementById("nb2Badge");

            if (sansNb2.includes(operation)) {
                nb2Input.disabled = true;
                nb2Input.value = "";
                nb2Badge.textContent = "Non requis";
                nb2Badge.className = "nb2-badge disabled";
            } else {
                nb2Input.disabled = false;
                nb2Badge.textContent = "Requis";
                nb2Badge.className = "nb2-badge";
            }
        }

        toggleNb2();
    </script>
</body>
</html>