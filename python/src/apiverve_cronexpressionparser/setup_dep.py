from setuptools import setup, find_packages

setup(
    name='apiverve_cronexpressionparser',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Cron Expression Parser is a comprehensive tool for parsing and validating cron expressions. It supports both 5-field and 6-field formats and returns detailed information about each field.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
