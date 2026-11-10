<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetPal - Provider Appointments</title>
    <!-- LINK TO CSS -->
    <link rel="stylesheet" href="../style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>

<!-- HEADER -->
<header class="site-header">
  <!-- LEFT: BUTTONS -->
  <div class="header-left">
    <a href="../homepage.html"><button class="header-button">Home</button></a>
    <a href="appointments.html"><button class="header-button">Appointments</button></a>
    <a href="dashboard.html"><button class="header-button">Dashboard</button></a>
    <button class="header-button">Help</button>
  </div>
  <!-- CENTER: LOGO AND RETURN TO HOMEPAGE -->
  <div class="header-center">
    <a href="../homepage.html"><img src="../images/petpallogo.png" alt="PetPal Header Logo" class="logo"></a>
  </div>
  <!-- RIGHT: LOGOUT -->
  <div class="header-right">
    <a href="../login.html"><button class="header-button">Logout</button></a>
  </div>
</header>
<!-- END OF HEADER -->

<body style="background-color: #cfe8cf">
    <section class="section" style="padding: 2rem;">
        <div class="container" style="max-width: 900px;">
            <div class="card">
                <div class="card-content" style="padding: 2rem;">
                    <h2 class="text-center mb-2" style="font-weight: 700; font-size: 1.8rem; margin-top:1rem">Upcoming Appointments</h2>
                    <p class="text-center text-muted mb-4">Manage your scheduled pet care bookings and client requests</p>

                    <!-- Appointments Table -->
                    <div class="table-responsive">
                        <table class="table table-hover align-middle">
                            <thead class="table-light">
                                <tr>
                                    <th>Client & Pet</th>
                                    <th>Service</th>
                                    <th>Date & Time</th>
                                    <th>Status</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Appointment 1 -->
                                <tr>
                                    <td>
                                        <strong>Corina PB</strong><br>
                                        <small class="text-muted">Pet: Tachanka (Newfoundland)</small>
                                    </td>
                                    <td>Pet Grooming</td>
                                    <td>
                                        Nov 9, 2026<br>
                                        <small class="text-muted">10:00 AM - 12:00 PM</small>
                                    </td>
                                    <td>
                                        <span class="badge bg-success">Confirmed</span>
                                    </td>
                                    <td>
                                        <button class="btn btn-sm btn-outline-primary mb-1">Details</button>
                                        <button class="btn btn-sm btn-outline-success mb-1">Complete</button>
                                    </td>
                                </tr>

                                <!-- Appointment 2 -->
                                <tr>
                                    <td>
                                        <strong>Michael Scott</strong><br>
                                        <small class="text-muted">Pet: Banjo (Golden Retriever)</small>
                                    </td>
                                    <td>Dog Walking</td>
                                    <td>
                                        Nov 10, 2026<br>
                                        <small class="text-muted">2:00 PM - 3:00 PM</small>
                                    </td>
                                    <td>
                                        <span class="badge bg-warning text-dark">Pending</span>
                                    </td>
                                    <td>
                                        <button class="btn btn-sm btn-outline-primary mb-1">Details</button>
                                        <button class="btn btn-sm btn-success mb-1">Accept</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <!-- Quick Navigation back to Dashboard -->
                    <div class="text-center mt-4">
                        <a href="dashboard.html" style="color: var(--primary-color); font-weight: 600; text-decoration: none;">&larr; Back to Provider Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>