<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function scanID() {
            // Aici vom apela o funcție JavaScript care simulează scanarea datelor de pe buletin.
            // Presupunem că avem un API sau o funcție definită pentru scanare care returnează un obiect cu datele de pe buletin.
            const scannedData = {
                nume: "Popescu",
                prenume: "Ion",
                cnp: "1234567890123"
            };

            // Populăm un câmp ascuns cu datele scanate
            document.getElementById('scannedData').value = JSON.stringify(scannedData);
            alert("Datele au fost scanate cu succes!");
        }
    </script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Creează un cont de Votant</h1>
        <form action="auth?action=signup" method="post" class="mt-4">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="parola" class="form-label">Parola</label>
                <input type="password" class="form-control" id="parola" name="parola" required>
            </div>
            <div class="mb-3">
                <label for="scan" class="form-label">Scanează datele de pe buletin:</label><br>
                <button type="button" class="btn btn-secondary" onclick="scanID()">Scan</button>
                <input type="hidden" id="scannedData" name="scannedData">
            </div>
            <button type="submit" class="btn btn-primary">Creează Cont</button>
        </form>
    </div>
</body>
</html>