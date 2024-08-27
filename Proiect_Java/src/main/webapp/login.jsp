<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logare</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-5">Logare</h1>
        <form method="post" action="auth?action=login">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="parola" class="form-label">Parola</label>
                <input type="password" class="form-control" id="parola" name="parola" required>
            </div>
            <button type="submit" class="btn btn-primary">Log In</button>
        </form>
    </div>
</body>
</html>