from django.contrib import admin
from django.urls import path, include
from homepage import views
from django.contrib.auth import views as auth_views

#urlpatterns = [
#url(r'^logout/$', auth_views.logout, {'next_page' : '/'}),
#url(r'^login/$', auth_views.login,  {'template_name':'memo_app/login.html'}),
#]

urlpatterns = [
    path('', include('homepage.urls')),
    path('admin/', admin.site.urls),
    #path('logout/', auth_views.logout),
    #path('login/', auth_views.login,  {'next_page':'settings.LOGIN_URL'}),
]
