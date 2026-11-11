<#import "layout.ftlh" as l>

<@l.layout title="PetPal - Login">
    <section class="section" style="padding: 4rem 2rem; display: flex; align-items: center; justify-content: center; min-height: 80vh;">
        <div class="container" style="max-width: 500px;">
            <div class="card shadow-sm">
                <div class="card-body p-4">
                    <h2 class="text-center mb-4" style="font-weight: 700; font-size: 1.8rem;">Welcome back to PetPal</h2>
                    <p class="text-center text-muted mb-4">Sign in to your account to manage your pet services</p>

                    <!-- Error Message Display -->
                    <#if error??>
                        <div class="alert alert-danger" role="alert">
                            ${error}
                        </div>
                    </#if>

                    <!-- Provider Login Form -->
                    <form method="POST">
                        <div class="form-group mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" id="email" name="email" class="form-control" placeholder="alex@example.com" required>
                        </div>

                        <div class="form-group mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="••••••••" required>
                        </div>

                        <div class="form-group mb-3 d-flex justify-content-between align-items-center">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="rememberMe">
                                <label class="form-check-label" for="rememberMe">Remember me</label>
                            </div>
                            <a href="#" style="text-decoration: none;">Forgot password?</a>
                        </div>

                        <button type="submit" formaction="/customer/login" class="btn btn-success btn-lg w-100 mt-2">
                            Sign in as a Customer
                        </button>

                        <button type="submit" formaction="/provider/login" class="btn btn-success btn-lg w-100 mt-2">
                            Sign in as a Service Provider
                        </button>
                    </form>

                    <p class="text-center mt-4">
                        Don't have an account? <a href="/provider/register" style="font-weight: 600; text-decoration: none;">Sign up here</a>
                    </p>
                </div>
            </div>
        </div>
    </section>
</@l.layout>