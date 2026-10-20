from setuptools import setup, find_packages

setup(
    name='apiverve_cronexpressionparser',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Cron Expression Parser decodes 5-field and 6-field cron expressions into human-readable schedules. Pass any cron string to verify syntax, read plain-language timing explanations, and get the next five execution timestamps.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/cronparser?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
