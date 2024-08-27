<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulare Votare</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-5">Candidati</h1>
        <div class="row">
            <c:forEach var="candidat" items="${candidati}">
                <div class="col-md-4">
                    <div class="card">
                        <img src="${candidat.poza}" class="card-img-top" alt="${candidat.nume}">
                        <div class="card-body">
                            <h5 class="card-title">${candidat.nume} ${candidat.prenume}</h5>
                            <p class="card-text">Partid: ${candidat.partid}</p>
                            <p class="card-text">Numar Voturi: ${candidat.numarVoturi}</p>
                            <c:if test="${not empty sessionScope.votantId}">
                                <form method="post" action="voteaza">
                                    <input type="hidden" name="candidatId" value="${candidat.id}">
                                    <button type="submit" class="btn btn-primary">Voteaza</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>