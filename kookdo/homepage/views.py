from django.shortcuts import render
from django.contrib.auth import authenticate, login

def index(request):
    return render(request, 'homepage/index.html', {})

def about_overview(request):
    return render(request, 'homepage/about_overview.html', {})