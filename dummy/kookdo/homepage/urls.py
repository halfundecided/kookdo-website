from django.urls import path, include
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('about_overview/', views.about_overview, name='about_overview'),
    path('accounts/', include('django.contrib.auth.urls'))
]
