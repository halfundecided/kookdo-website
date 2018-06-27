from django.contrib import admin
from django.urls import path, include
from homepage import views

urlpatterns = [
    path('', include('homepage.urls')),
    path('admin/', admin.site.urls),
]
