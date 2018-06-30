from django.shortcuts import render

def index(request):
    return render(request, 'homepage/index.html', {})

def about_overview(request):
    return render(request, 'homepage/about_overview.html', {})
